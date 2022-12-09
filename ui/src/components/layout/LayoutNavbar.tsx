import React from "react";
import {createStyles, Image, Navbar, ScrollArea} from "@mantine/core";
import {IconAdjustments, IconCalendarStats, IconFileAnalytics, IconGauge, IconLock, IconNotes, IconPresentationAnalytics} from "@tabler/icons";
import NavbarLinkGroup from "./NavbarLinkGroup";


const mockdata = [
    {label: 'Dashboard', icon: IconGauge},
    {
        label: 'Market news',
        icon: IconNotes,
        links: [
            {label: 'Overview', link: '/'},
            {label: 'Forecasts', link: '/'},
            {label: 'Outlook', link: '/'},
            {label: 'Real time', link: '/'},
        ],
    },
    {
        label: 'Releases',
        icon: IconCalendarStats,
        links: [
            {label: 'Upcoming releases', link: '/'},
            {label: 'Previous releases', link: '/'},
            {label: 'Releases schedule', link: '/'},
        ],
    },
    {label: 'Analytics', icon: IconPresentationAnalytics},
    {label: 'Contracts', icon: IconFileAnalytics},
    {label: 'Settings', icon: IconAdjustments},
    {
        label: 'Security',
        icon: IconLock,
        links: [
            {label: 'Enable 2FA', link: '/'},
            {label: 'Change password', link: '/'},
            {label: 'Recovery codes', link: '/'},
        ],
    },
];

const useStyles = createStyles((theme) => ({
    navbar: {
        backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[6] : theme.white,
        paddingBottom: 0,
    },

    header: {
        padding: theme.spacing.md,
        paddingTop: 0,
        marginLeft: -theme.spacing.md,
        marginRight: -theme.spacing.md,
        color: theme.colorScheme === 'dark' ? theme.white : theme.black,
        borderBottom: `1px solid ${
            theme.colorScheme === 'dark' ? theme.colors.dark[4] : theme.colors.gray[3]
        }`,
    },

    links: {
        marginLeft: -theme.spacing.md,
        marginRight: -theme.spacing.md,
    },

    linksInner: {
        paddingTop: theme.spacing.xl,
        paddingBottom: theme.spacing.xl,
    },
}));

export const LayoutNavbar = () => {
//https://ui.mantine.dev/component/navbar-nested

    const {classes} = useStyles();

    const links = mockdata.map((item) => <NavbarLinkGroup label={item.label} icon={item.icon} links={item.links} key={item.label}/>);

    return (
        <Navbar className={classes.navbar} width={{sm: 300}} p="md">

            <Navbar.Section className={classes.header}>
                <Image
                    src="https://images.unsplash.com/photo-1511216335778-7cb8f49fa7a3?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=720&q=80"
                />
            </Navbar.Section>

            <Navbar.Section className={classes.links} grow component={ScrollArea}>
                <div className={classes.linksInner}>{links}</div>
            </Navbar.Section>

        </Navbar>
    );
};

//Navbar