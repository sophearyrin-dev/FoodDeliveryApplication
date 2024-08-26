export interface FoodItem {
  id: number;
  name?: string;
  description?: string;
  isVegetarian?: boolean;
  price?: number;
  restaurantId?: number;
  quantity: number;
}

