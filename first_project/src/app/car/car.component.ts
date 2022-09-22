import {Component} from '@angular/core';

@Component({
  selector: 'app-car',
  template: `
    <h2>Test Car!</h2>
    <p>Testing text for this page!</p>
  `,
  // styleUrls: ['./car.component.css']
  styles: [
    `
    h2{
      color: aqua;
    }
    p{
     color: blueviolet;
    }

    `
  ]
})
export class CarComponent {

}
