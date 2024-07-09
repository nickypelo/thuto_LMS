import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/services/models/question';
import { QuestionService } from 'src/app/services/services/question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit{

  information: Question[] = [];

  constructor(private questionService: QuestionService){}

  ngOnInit(): void {
  //   this.questionService.getAllQuestions()
  //   .subscribe(response => {
  //     this.information = response;
  //     console.log(this.information);
  //   },
  // );
  }

}
