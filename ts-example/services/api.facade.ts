import { users, USERS_API_URI } from "../mocks/users";

export function fakeFetch(uri: string) {
  if (uri !== USERS_API_URI) {
    throw new Error("wrong API uri");
  }
  return users;
}
