import config from "config";

let instance = axios.create({
  baseURL: config.API_BASE_URL,
});


export function postAuthTicket(ticket, serviceUrl) {
  return instance.post(`/auth/v2/`, {
    ticket,
    service_url: serviceUrl,
  });
}

export const postSsoCompletionData = async ({ completionId, npm, kdOrg }) =>
  await instance.post("/auth/completion/", {
    completion_id: completionId,
    npm: npm,
    kd_org: kdOrg,
  });

