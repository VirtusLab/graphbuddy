import { getUsers } from "./users.service";
import { sendEmailToUsers } from "./send-email-to-users";
import { CONFIG_MESSAGE } from "../config";

export function getUsersAndSendEmail() {
  const users = getUsers();
  sendEmailToUsers(users);
  console.log(CONFIG_MESSAGE);
}
