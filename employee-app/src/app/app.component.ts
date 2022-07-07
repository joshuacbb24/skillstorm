import { Component } from '@angular/core';

// @Component decorator - metadata to tell Angular what to do
@Component({
  selector: 'app-root', // custom HTML element (tag) that represents your component
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'employee-app';

  
}
