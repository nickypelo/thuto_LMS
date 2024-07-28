import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LearnerComponent } from './pages/learner/learner.component';
import { TopicComponent } from './components/learner/topic/topic.component';
import { QuizComponent } from './components/learner/quiz/quiz.component';
import { SubjectComponent } from './components/learner/subject/subject.component';
import { QuestionComponent } from './components/question/question.component';
import { GradeComponent } from './components/grade/grade.component';
import { AuthComponent } from './pages/auth/auth.component';
import { TeacherComponent } from './pages/teacher/teacher.component';
import { ClassTopicsComponent } from './components/teacher/class-topics/class-topics.component';
import { ClassQuizzesComponent } from './components/teacher/class-quizzes/class-quizzes.component';
import { ClassGradesComponent } from './components/teacher/class-grades/class-grades.component';
import { StudentsComponent } from './components/teacher/students/students.component';


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
  {
    path: 'teacher',
    component: TeacherComponent,
    children: [
      {path: `class-topics`, component: ClassTopicsComponent},
      {path: `class-quizzes`, component: ClassQuizzesComponent},
      {path: `students`, component: StudentsComponent},
      {path: `class-grades`, component: ClassGradesComponent}
    ]
  },
  {path: '**', redirectTo: 'login'},

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
