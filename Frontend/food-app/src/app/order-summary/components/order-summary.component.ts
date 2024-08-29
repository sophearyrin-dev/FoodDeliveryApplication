import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderDTO } from '../models/OrderDTO';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent {

  orderSummary?: OrderDTO;
  obj: any;
  total?: number;
  showDialog: boolean = false;

  constructor(private route: ActivatedRoute, private orderService: OrderService, private router: Router) { }
  
  ngOnInit() {
    const data = this.route.snapshot.queryParams['data'];
    if (data) {
      this.obj = JSON.parse(data);
      this.obj.userId = 1;
      this.orderSummary = this.obj;

      if (this.orderSummary && this.orderSummary.foodItems) {
        this.total = this.orderSummary.foodItems.reduce((accumulator, currentValue) => {
          return accumulator + (currentValue.quantity * (currentValue.price ?? 0));
        }, 0);
        
      }
    }
  }

  saveOrder() {
    if (this.orderSummary) {
      this.orderService.saveOrder(this.orderSummary)
        .subscribe(
          response => {
            this.showDialog = true;
          },
          error => {
            console.error('Failed to save data:', error);
          }
        );
    } else {
      console.error('Order summary is undefined.');
    }
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']); // Replace '/' with the actual route for your home page
  }

}
