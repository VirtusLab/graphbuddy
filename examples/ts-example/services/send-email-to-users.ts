import { User } from "./users.service";
import { sendSingleEmailToUser } from "./send-single-email-to-user";
import { CONFIG_MESSAGE } from "../config";

export function sendEmailToUsers(users: User[]) {
  users.forEach(sendSingleEmailToUser);
  console.log(CONFIG_MESSAGE);
}
