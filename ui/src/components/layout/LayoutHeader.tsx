import React from "react";
import {ActionIcon, Burger, Button, createStyles, Group, Header, useMantineColorScheme} from "@mantine/core";
import {IconMoonStars, IconSun} from "@tabler/icons";
import {useAuth0} from "@auth0/auth0-react";
import UserInfo from "./UserInfo";

// add this div for more header content to align items
// <div className={classes.inner}>

const useStyles = createStyles((theme) => ({
    header: {
        paddingLeft: theme.spacing.md,
        paddingRight: theme.spacing.md,
    },
    inner: {
        height: 60,
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
    }
}));

const LayoutHeader = () => {

    const {classes} = useStyles();

    const {isAuthenticated, loginWithRedirect, logout, isLoading} = useAuth0();
    const {colorScheme, toggleColorScheme} = useMantineColorScheme();

    return (
        <Header height={60} mb={120} className={classes.header}>
                <Group sx={{height: '100%'}} px={20} position="right">
                    <ActionIcon variant="default" onClick={() => toggleColorScheme()} size={30}>
                        {colorScheme === "dark" ? <IconSun size={16}/> : <IconMoonStars size={16}/>}
                    </ActionIcon>

                    {!isAuthenticated &&
                            <Button onClick={() => loginWithRedirect()} loading={isLoading}>
                                Login
                            </Button>
                    }
                    {isAuthenticated &&
                            <>
                                <UserInfo/>
                                <Button onClick={() => logout()} loading={isLoading}>Logout</Button>
                            </>

                    }

                </Group>
        </Header>
    );
};

export default LayoutHeader;
