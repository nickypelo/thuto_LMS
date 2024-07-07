import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LearnerComponent } from './pages/learner/learner.component';
import { TopicComponent } from './components/topic/topic.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { SubjectComponent } from './components/subject/subject.component';
import { QuestionComponent } from './components/question/question.component';
import { GradeComponent } from './components/grade/grade.component';
import { AuthComponent } from './pages/auth/auth.component';


const routes: Routes = [
  {path: 'login',component: AuthComponent},
  {
    path: 'learner', 
    component: LearnerComponent},
  {
    path: 'subject',
    component: SubjectComponent,
    children: [
      {path: `topics`, component: TopicComponent},
      {path: `quizzes`, component: QuizComponent},
      {path: `1`, component: QuestionComponent},
      {path: `grades`, component: GradeComponent}
    ]
  },
  {path: '**', redirectTo: 'login'},

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
