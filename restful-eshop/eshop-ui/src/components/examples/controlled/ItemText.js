import React from "react";

export default class ItemText extends React.Component {

    componentDidMount() {
        console.log("Komponentas mauntinamas...");
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        const {text} = this.props.item;

        //if (text !== prevProps.item.text) {
            console.log("Atnaujinam reiksmes");
       // }
    }

    componentWillUnmount() {
        console.log("Unmaunting component...");
    }

    render() {
        return (
            <div>Ivestas item comentas: {this.props.item.text}
                <button className="btn btn-outline-secondary"
                        type="button"
                        onClick={() => this.props.onHandlingHideText(this.props.item.id)}>Hide?
                </button>
            </div>
        );
    }
}
