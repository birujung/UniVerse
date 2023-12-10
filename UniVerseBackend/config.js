const config = {
  base: {
    DOMAIN: window.location.origin,
    SSO_UI_URL: "https://sso.ui.ac.id/cas2",
    AIRTABLE_BASE_ID: process.env.REACT_APP_BETA_AIRTABLE_BASE_ID,
    AIRTABLE_API_KEY: process.env.REACT_APP_BETA_AIRTABLE_API_KEY,
    AIRTABLE_TABLE_NAME: process.env.REACT_APP_BETA_AIRTABLE_TABLE_NAME
  },
  production: {
    API_BASE_URL: process.env.REACT_APP_AWS_BACKEND_URL,
    BASE_URL: "/"
  },
  development: {
    API_BASE_URL: "http://localhost:5000/tes",
    BASE_URL: "/"
  }
};

export default {
  ...config.base,
  ...config[process.env.NODE_ENV || "development"]
};
