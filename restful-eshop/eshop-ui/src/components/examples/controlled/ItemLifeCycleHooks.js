import {useEffect, useState} from "react";

export default ({timeOut}) => {

    const [loading, setLoading] = useState(true);

    useEffect(() => {
        console.log("Mountinam....");

        setTimeout(() => {
            setLoading(false);
        }, timeOut);

        return () => {
            console.log("updating, unmounting....");
        }
    });

    return (
        <>
            {loading && <div>Loading...</div>}
            {!loading && <div>Duomenys uzkrauti !!!!!</div>}
        </>
    );
}
