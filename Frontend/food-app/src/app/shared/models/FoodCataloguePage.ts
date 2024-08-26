import { FoodItem } from "./FoodItem";
import { Restaurant } from "./Restaurant";

export interface FoodCataloguePage{
  foodItems?:FoodItem[];
  restaurant?:Restaurant;
}