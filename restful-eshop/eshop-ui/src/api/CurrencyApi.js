import HTTP from "./index";

const fetchCurrencies = () => HTTP.get('/currencies');

export {fetchCurrencies}
