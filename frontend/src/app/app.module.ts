import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CollapseDirective } from 'ng2-bootstrap';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot([
            { path: '', redirectTo: '/welcome', pathMatch: 'full' },
            { path: 'login', component: LoginComponent },
            { path: 'welcome', component: WelcomeComponent }
        ])
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        WelcomeComponent,
        CollapseDirective
    ],
    bootstrap: [AppComponent]
})
export class AppModule {

}
