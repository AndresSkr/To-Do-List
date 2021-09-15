import { TaskCode } from "./task-code.interface";

export interface Item {
    taskCode: TaskCode;
    name:     string;
    done:     boolean;
    id:       number;
}