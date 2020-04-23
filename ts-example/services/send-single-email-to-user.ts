import { User } from "./users.service";
import { KtugEmailFactory } from "./KtugEmailFactory";
import { CONFIG_MESSAGE } from "../config";

export function sendSingleEmailToUser(user: User) {
  const ef = new KtugEmailFactory(user.email);
  ef.sendEmail();
  console.log(CONFIG_MESSAGE);
}
