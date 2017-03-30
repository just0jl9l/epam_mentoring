import { Component } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'app',
    templateUrl: 'app.component.html'
})
export class AppComponent { 
    name: string = 'Angular'; 
    isCollapsed: boolean = true;

    toggleNavBar(){
        this.isCollapsed = !this.isCollapsed;
    }
 }
