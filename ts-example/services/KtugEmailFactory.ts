import { EmailFactory } from "./email.factory";
import { CONFIG_MESSAGE } from "../config";

export class KtugEmailFactory extends EmailFactory {
  from = "KTUG organizer";
  title = "Thanks for attending in KTUG";
  body = "Welcome on Kraków Typescript user group...";
  constructor(to: string) {
    super(to);
    console.log(CONFIG_MESSAGE);
  }
}
