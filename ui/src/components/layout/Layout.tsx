import React from "react";
import {AppShell} from '@mantine/core';
import {LayoutNavbar} from "./LayoutNavbar";
import LayoutHeader from "./LayoutHeader";
import AppRouter from "../../router/AppRouter";

const Layout = () => {

    return (
        <AppShell
            padding="md"
            navbar={<LayoutNavbar/>}
            header={<LayoutHeader/>}
            styles={(theme) => ({
                main: {
                    backgroundColor:
                        theme.colorScheme === 'dark' ? theme.colors.dark[8] : theme.colors.gray[0],
                },
            })}
        >
            <AppRouter/>
        </AppShell>

    );
};

export default Layout;