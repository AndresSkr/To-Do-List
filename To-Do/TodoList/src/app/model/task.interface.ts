import { Item } from "./item.interface";

export interface Tasks {
    id:    number;
    name:  string;
    items: Item[];
}

export interface Task {
    name:  string;
}

