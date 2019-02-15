import { NgModule } from '@angular/core';

import { IdmSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [IdmSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [IdmSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class IdmSharedCommonModule {}
