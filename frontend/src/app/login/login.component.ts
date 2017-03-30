import { Component } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'login',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})
export class LoginComponent { 
    login: string = '';
    password: string = '';

    test() {
        alert(this.login + ' 1 ' + this.password);
    }
}