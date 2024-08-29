// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-food-catalogue',
//   templateUrl: './food-catalogue.component.html',
//   styleUrl: './food-catalogue.component.css'
// })
// export class FoodCatalogueComponent {

// }


import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodCataloguePage } from '../../shared/models/FoodCataloguePage';
import { FoodItem } from '../../shared/models/FoodItem';
import { FoodItemService } from '../services/food-item.service';


@Component({
  selector: 'app-food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrls: ['./food-catalogue.component.css']
})
export class FoodCatalogueComponent {

  restaurantId: number;
  foodItemResponse: FoodCataloguePage;
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCataloguePage;


  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router: Router) {
  }

  ngOnInit() {

    this.route.paramMap.subscribe(params => {
      // this.restaurantId = +params.get('id');
      this.restaurantId = +(params.get('id') ?? 0);  // Fallback to 0 if `id` is null

    });

    this.getFoodItemsByRestaurant(this.restaurantId);

  }

  getFoodItemsByRestaurant(restaurant: number) {
    this.foodItemService.getFoodItemsByRestaurant(restaurant).subscribe(
      data => {
        this.foodItemResponse = data;
      }
    )
  }

  increment(food: any) {
    food.quantity++;
    const index = this.foodItemCart.findIndex(item => item.id === food.id);
    if (index === -1) {
      // If record does not exist, add it to the array
      this.foodItemCart.push(food);
    } else {
      // If record exists, update it in the array
      this.foodItemCart[index] = food;
    }
  }

  decrement(food: any) {
    if (food.quantity > 0) {
      food.quantity--;

      const index = this.foodItemCart.findIndex(item => item.id === food.id);
      if (this.foodItemCart[index].quantity == 0) {
        this.foodItemCart.splice(index, 1);
      } else {
        // If record exists, update it in the array
        this.foodItemCart[index] = food;
      }

    }
  }

  // onCheckOut() {
  //   this.foodItemCart;
  //   this.orderSummary = {
  //     foodItemsList: this.foodItemCart,
  //     restaurant: this.foodItemResponse?.restaurant || null
  //   }
  
  //   this.orderSummary.foodItems = this.foodItemCart;
  //   this.orderSummary.restaurant = this.foodItemResponse.restaurant;
  //   this.router.navigate(['/orderSummary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
  // }

  onCheckOut() {
    // Ensure that the object matches the FoodCataloguePage interface
    this.orderSummary = {
      foodItems: this.foodItemCart,  // Correct property name used here
      restaurant: this.foodItemResponse?.restaurant || null  // Handling potential null value
    };
  
    this.router.navigate(['/orderSummary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
  }
  




}
