import {makeStyles} from "@material-ui/core/styles";
import {Card, CardActions, CardContent, CircularProgress} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";
import {useEffect, useState} from "react";
import {fetchWeather} from "../../api/WeatherApi";

const useStyles = makeStyles({
    root: {
        maxWidth: 275,
    },
    bullet: {
        display: 'inline-block',
        margin: '0 2px',
        transform: 'scale(0.8)',
    },
    title: {
        fontSize: 14,
    },
    pos: {
        marginBottom: 12,
    },
    circular: {
        position: 'fixed',
        top: '50%',
        left: '50%'
    }
});
const Weather = () => {
    const [loading, setLoading] = useState(true);
    const [weather, setWeather] = useState();

    useEffect(() => {
        fetchWeather().then(({data}) => {
            setWeather(data);
        }).finally(() => setLoading(false))
    }, []);

    const classes = useStyles();

    return (
        <>
        {loading ? <CircularProgress className={classes.circular}/> :

            <Card className={classes.root}>
                <CardContent>
                    <Typography className={classes.title} color="textSecondary" gutterBottom>
                        {weather.name}
                    </Typography>
                    <Typography variant="h5" component="h2">
                    </Typography>
                    <Typography className={classes.pos} color="textSecondary">
                        {Math.round(weather.main.temp -273.15)} °C  {weather.weather[0].description}
                    </Typography>

                    <Typography variant="body2" component="p">
                        Min: {Math.round(weather.main.temp_min -273.15)} °C
                        <br/>
                        Max: {Math.round(weather.main.temp_min -273.15)} °C
                    </Typography>
                </CardContent>
            </Card>
        }
        </>
    );
};

export default Weather;
