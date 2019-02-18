package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import model.ProjectVideoGen;

public class main {

	private static int NB_PLAYLIST = 10;
	
	public static void main(String[] args) {
		List<ProjectVideoGen> projects;
		String args0 = args[0];
		if (args[0].lastIndexOf("/") != args[0].length() - 1) {
			args0 += "/";
		}

		String unzipDirectoryName = "IDM_unzip_folder";

		File folder = new File(args[0]);
		if (args[0] == null || !folder.exists()) {
			System.err.println("The arguments is not a valid folder: " + args[0]);
			System.exit(1);
		}
		System.out.println("Unzipping files...");
		//unzipFiles(args0, folder.listFiles(), unzipDirectoryName);

		
		projects = getVideoGenSpecsPath(args0 + unzipDirectoryName);
		System.out.println("\nList of project video gen detected " + projects.size() + ":");
		for(ProjectVideoGen  project: projects) {
			System.out.println("-"+project.getTitle());
		}
		
		projects = genPlaylist(projects);
		
		String log = "";
		for (ProjectVideoGen project : projects) {
			log += project.toLog();
		}
		String logPath = args0 + "log.txt";
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(logPath));
			writer.write(log);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n Log file \"log.txt\" has been generated at " + logPath + ".");
		
	}

	/**
	 * Unzip all the file in the parentPath
	 * 
	 * @param parentPath
	 * @param listOfZipFiles
	 * @param outputFolder
	 * @return name of zip file detected
	 */
	private static List<String> unzipFiles(String parentPath, File[] listOfZipFiles, String outputFolder) {
		if (listOfZipFiles == null) {
			listOfZipFiles = new File[0];
		}
		if (parentPath == null) {
			parentPath = "";
		}
		if (outputFolder == null) {
			outputFolder = "";
		}
		List<String> zipFiles = new ArrayList<>();
		String unzipCommand;
		String fileName;
		List<Process> unzipProcess = new ArrayList<>();
		// Unzip all files
		for (File compressedFile : listOfZipFiles) {
			fileName = compressedFile.getName();
			if (fileName.lastIndexOf(".zip") != -1) {
				
				zipFiles.add(fileName.substring(0, fileName.lastIndexOf(".")));
				unzipCommand = "unzip ";
				unzipCommand += parentPath;
				unzipCommand += fileName;
				unzipCommand += " -d ";
				unzipCommand += parentPath;
				unzipCommand += outputFolder;
				System.out.println("-"+fileName);
				try {
					unzipProcess.add(Runtime.getRuntime().exec(unzipCommand));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// wait all process to end
		for (Process process : unzipProcess) {
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return zipFiles;
	}

	/**
	 * Get all the path from the parentPath include until the file .videogen
	 * 
	 * @param parentPath
	 * @return
	 */
	private static List<ProjectVideoGen> getVideoGenSpecsPath(String parentPath) {
		if (parentPath == null) {
			parentPath = "";
		}
		List<ProjectVideoGen> projects = new ArrayList<>();
		ProjectVideoGen project;
		String videogenFileName;
		String videogenFilePath;
		String inputFileName;
		String projectPath;
		File intputFolders = new File(parentPath);
		File[] listOfInputFolder1 = intputFolders.listFiles();
		File[] listOfInputFolder2;
		for (File inputFolder : listOfInputFolder1) {
			if (inputFolder.isDirectory()) {

				inputFileName = inputFolder.getName();
				listOfInputFolder2 = inputFolder.listFiles();
				for (File inputFile : listOfInputFolder2) {
					if (inputFile.getName().indexOf(".videogen") != -1) {
						videogenFileName = inputFile.getName();
						videogenFilePath = parentPath + "/" + inputFileName + "/" + videogenFileName;
						projectPath = parentPath + "/" + inputFileName + "/";
						project = new ProjectVideoGen(inputFileName, projectPath, videogenFilePath, NB_PLAYLIST);
						projects.add(project);
					}
				}
			}
		}
		return projects;

	}

	private static List<ProjectVideoGen> genPlaylist(List<ProjectVideoGen> projectsVideoGen) {
		if (projectsVideoGen == null) {
			projectsVideoGen = new ArrayList<>();
		}
		for (ProjectVideoGen project : projectsVideoGen) {
			PlaylistService service = new PlaylistService(project.getPathVideoGenSpec());
			service.process(project, project.getTitle());
			if(project.hasError()) {
				System.out.println("Playlists for project "+ project.getTitle() +" has encountered an error.");
			}else {
				System.out.println("Playlists for project "+ project.getTitle() + " has been generated in:\n" + project.getDirectory());
			}
		}

		return projectsVideoGen;
	}
}
