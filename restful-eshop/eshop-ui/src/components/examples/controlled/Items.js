import React from "react";
import Item from "./Item";
import ItemLifeCycleHooks from "./ItemLifeCycleHooks";
import ItemsActions from "./ItemsActions";
import ItemHeader from "./ItemHeader";

export default class Items extends React.Component {

    constructor(props, context) {
        super(props, context);

        this.state = {
            items: [
                {id: 1, text: '', quantity: 0, isItemTextVisible: false},
                {id: 2, text: '', quantity: 0, isItemTextVisible: false},
                {id: 3, text: '', quantity: 0, isItemTextVisible: false},
                {id: 4, text: '', quantity: 0, isItemTextVisible: false}
            ],
            totalCount: 0
        }
    }

    onHandlingAddQuantity = (item) => {
        const items = [...this.state.items];
        const index = items.indexOf(item);
        items[index] = {...item};
        items[index].quantity++;

        this.setState({items});

        this.updateTotalCount();
    }

    onHandlingRemoveQty = (item) => {
        const items = [...this.state.items];
        const index = items.indexOf(item);
        items[index] = {...item};
        items[index].quantity--;

        this.setState({items});

        this.updateTotalCount();
    }

    onHandlingItemText = (event, id) => {
        const items = this.state.items.map(item => {
            if (item.id === id) {
                item.text = event.target.value;
                item.isItemTextVisible = true;
            }
            return item;
        });

        this.setState({items});
    }

    onHandlingHideText = (id) => {
        const items = this.state.items.map(item => {
            if (item.id === id) {
                item.isItemTextVisible = false;
            }
            return item;
        });

        this.setState({items});
    }

    onHandlingDeleteItem = (id) => {
        const items = this.state.items.filter(item => item.id !== id);
        this.setState({items});

        this.updateTotalCount();
    }

    onHandlingAddItem = () => {
        const items = [...this.state.items];
        let max = 0;

        if (items && items.length > 0) {
            max = items[0].id;
            for (let i = 1, len = items.length; i < len; i++) {
                if (items[i].id > max) {
                    max = items[i].id;
                }
            }
        }

        items.push({id: max + 1, text: '', quantity: 0, isItemTextVisible: false});

        this.setState({items});
    }

    onHandlingResetQuantity = () => {
        const items = this.state.items.map(item => {
            item.quantity = 0;
            return item;
        })

        this.setState({items});

        this.updateTotalCount();
    }

    updateTotalCount() {
        setTimeout(() => {
            let totalCount = 0;
            const {items} = this.state;
            for (let i = 0, len = items.length; i < len; i++) {
                totalCount += items[i].quantity;
            }
            this.setState({totalCount});
        }, 0);
    }

    render() {
        return (
            <>
                <ItemHeader totalCount={this.state.totalCount}/>
                <ItemLifeCycleHooks timeOut={2000}/>
                {
                    this.state.items.map(item => <Item key={item.id}
                                                       item={item}
                                                       onHandlingItemText={this.onHandlingItemText}
                                                       onHandlingAddQuantity={this.onHandlingAddQuantity}
                                                       onHandlingRemoveQuantity={this.onHandlingRemoveQty}
                                                       onHandlingHideText={this.onHandlingHideText}
                                                       onHandlingDeleteItem={this.onHandlingDeleteItem}/>)
                }
                <ItemsActions onHandlingAddItem={this.onHandlingAddItem}
                              onHandlingResetQuantity={this.onHandlingResetQuantity}/>
            </>
        );
    }
}
