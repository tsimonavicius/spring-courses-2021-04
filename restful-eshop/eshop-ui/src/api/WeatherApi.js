import HTTP from "./index";

const fetchWeather = () => HTTP.get('/weather');

export {fetchWeather}
