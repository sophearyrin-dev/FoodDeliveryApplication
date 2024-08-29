import { NgModule } from '@angular/core';
import { OrderSummaryComponent } from './components/order-summary.component';
import { RouterModule, Routes } from '@angular/router';



const routes: Routes = [
  { path: 'orderSummary', component: OrderSummaryComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderSummaryModule { }
