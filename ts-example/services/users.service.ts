import { fakeFetch } from "./api.facade";

const API_ENDPOINT = "https://api.ktug.com";
export type User = {
  name: string;
  email: string;
};

export function getUsers() {
  return fakeFetch(`${API_ENDPOINT}/users`);
}
