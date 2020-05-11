import { getUsersAndSendEmail } from "./services/user.helper";
import { CONFIG_MESSAGE } from "./config";

function init() {
  getUsersAndSendEmail();
  console.log(CONFIG_MESSAGE);
}

init();
