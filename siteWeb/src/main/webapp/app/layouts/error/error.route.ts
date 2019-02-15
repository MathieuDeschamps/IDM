import { Routes } from '@angular/router';

import { ErrorComponent } from './error.component';

export const errorRoute: Routes = [
    {
        path: 'error',
        component: ErrorComponent,
        data: {
            authorities: [],
            pageTitle: 'IDM'
        }
    },
    {
        path: 'accessdenied',
        component: ErrorComponent,
        data: {
            authorities: [],
            pageTitle: 'IDM',
            error403: true
        }
    },
    {
        path: '404',
        component: ErrorComponent,
        data: {
            authorities: [],
            pageTitle: 'IDM',
            error404: true
        }
    },
    {
        path: '**',
        redirectTo: '/404'
    }
];
