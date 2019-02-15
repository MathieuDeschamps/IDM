import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { LoginModalService, AccountService, Account } from 'app/core';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;
    checks: any[];

    

    constructor(
        private accountService: AccountService,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager
    ) 
    {
        this.checks = [false, false, false, false, false, false, false, false, false, false];
    }

    ngOnInit() {
        this.accountService.identity().then((account: Account) => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();

    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', message => {
            this.accountService.identity().then(account => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.accountService.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

    generate(){
        let ids = '';
        for (let i = 1; i < this.checks.length; i++) {
            if( this.checks[i] )
            {
                ids = ids + i + ",";
            }
        };
        console.log(ids);
        ids = ids.substring(0, ids.length - 1);
        //video.src = 'http://localhost:8080/api/video/' + ids;
    }

    check1(event){      
        this.checks[event.target.id] = event.target.checked;
       
    }

    check2(event){
        
    }
}
