import React from "react";
import {useAuth0} from "@auth0/auth0-react";
import { Button } from "@mantine/core";

const Dashboard = () => {

    const {getAccessTokenSilently} = useAuth0();

    const callApi = async () => {
        const token = await getAccessTokenSilently();
        console.log(token)
        return <></>
    }

    return (
        <Button onClick={()=> callApi()}>Dashboard</Button>
    );
};

export default Dashboard;
