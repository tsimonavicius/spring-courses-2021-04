import {useEffect, useState} from "react";
import {fetchCurrencies} from "../../api/CurrencyApi";
import {
    CircularProgress, Grid,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@material-ui/core";
import Container from "@material-ui/core/Container";
import {makeStyles} from "@material-ui/styles";
import {useTranslation} from "react-i18next";

const useStyle = makeStyles((theme) =>({
    table: {
        minWidth: 450,
    },
    circular: {
        position: 'fixed',
        top: '50%',
        left: '50%'
    }
}));

const Currency = () => {
    const [currencies, setCurrencies] = useState();
    const [loading, setLoading] = useState(true);

    const {t} = useTranslation('currency');

    useEffect(() => {
        fetchCurrencies().then(({data}) => {
            setCurrencies(data);
        }).finally(() => setLoading(false))
    }, []);

    const classes = useStyle();

    return (
        <>
        {loading ? <CircularProgress className={classes.circular}/> :
                <Container maxWidth="md">
                    <TableContainer component={Paper} className={classes.table}>
                        <Table aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>{currencies.base}</TableCell>
                                    <TableCell>{t('value')}</TableCell>
                                    <TableCell>{t('currency')}</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {
                                    Object.entries(currencies.rates).map(([key, value]) => (
                                        <TableRow>
                                            <TableCell>1</TableCell>
                                            <TableCell>{value}</TableCell>
                                            <TableCell>{key}</TableCell>
                                        </TableRow>
                                    ))
                                }
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Container>
        }
        </>
    );
}

export default Currency;
