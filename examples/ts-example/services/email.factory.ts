import { CONFIG_MESSAGE } from "../config";

export class EmailFactory {
  from: string;
  to: string;
  title: string;
  body: string;

  constructor(to: string) {
    this.to = to;
  }
  setTitle(title: string) {
    this.title = title;
  }

  setFrom(from: string) {
    this.from = from;
  }

  setTo(to: string) {
    this.to = to;
  }

  setBody(body: string) {
    this.body = body;
  }

  sendEmail() {
    console.log(this.from, this.to, this.title, this.body);
    console.log("email sent");
    console.log(CONFIG_MESSAGE);
  }
}
