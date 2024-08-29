import { FoodItem } from "../../shared/models/FoodItem";
import { Restaurant } from "../../shared/models/Restaurant";


export interface OrderDTO{

  foodItems?: FoodItem[];
    userId?: number;
    restaurant?: Restaurant;
}