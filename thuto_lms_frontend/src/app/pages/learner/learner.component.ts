import { Component } from '@angular/core';

@Component({
  selector: 'app-learner',
  templateUrl: './learner.component.html',
  styleUrls: ['./learner.component.css']
})
export class LearnerComponent {

  mySubjects: String[] = ["Mathematics", "Life Skills", "English - First Additional Language",
     "Economic Management Science", "Technology"
    ]

}
