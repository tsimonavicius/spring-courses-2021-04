import {useEffect, useState} from "react";
import {fetchCurrencies} from "../../api/CurrencyApi";

const Currency = () => {
    const [currencies, setCurrencies] = useState();
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetchCurrencies().then(({data}) => {
            setCurrencies(data);
        }).finally(() => setLoading(false))
    }, []);

    return (
        <>
            {
                loading ? <span>Loading...</span> :
                    <div>
                        <div>{currencies.base}</div>
                        <div>{currencies.date}</div>
                        {
                            Object.entries(currencies.rates).map(([key, value]) => (
                                <div>{key}: {value}</div>
                            ))
                        }
                    </div>
            }
        </>
    );
}

export default Currency;
