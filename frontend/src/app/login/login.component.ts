import { Component } from '@angular/core';
import { Http, URLSearchParams } from "@angular/http";
import { Router } from '@angular/router';

import 'rxjs/add/operator/toPromise';

const loginApiPage: string = '/api/login';

@Component({
    moduleId: module.id,
    selector: 'login',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css']
})
export class LoginComponent {
    login: string = '';
    password: string = '';
    error: { messege: string } = undefined;

    constructor(private http: Http, private router: Router) { }

    submit() {
        let body = new URLSearchParams();
        body.set('username', this.login);
        body.set('password', this.password);
        this.error = undefined;
        let responseCode: number;
        this.http
            .post(loginApiPage, body)
            .toPromise()
            .then(response => {
                alert('!!!');
                responseCode = response.status;
                if (responseCode == 200) {
                    this.router.navigateByUrl('/welcome');
                } else {
                    this.error = { messege: "Login attempt failed " + responseCode };
                }
            }).catch(error => {
                this.error = { messege: "Login attempt failed. " + (error.message || error) };
            });
    }
}