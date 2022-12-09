import React, {useState} from "react";
import {IconActivity, IconChevronLeft, IconChevronRight, TablerIcon} from "@tabler/icons";
import {Box, Collapse, createStyles, Group, ThemeIcon, UnstyledButton, Text} from "@mantine/core";
import { NavLink as RouterNavLink} from "react-router-dom";

const useStyles = createStyles((theme) => ({
    control: {
        fontWeight: 500,
        display: 'block',
        width: '100%',
        padding: `${theme.spacing.xs}px ${theme.spacing.md}px`,
        color: theme.colorScheme === 'dark' ? theme.colors.dark[0] : theme.black,
        fontSize: theme.fontSizes.sm,

        '&:hover': {
            backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[7] : theme.colors.gray[0],
            color: theme.colorScheme === 'dark' ? theme.white : theme.black,
        },
    },

    link: {
        fontWeight: 500,
        display: 'block',
        textDecoration: 'none',
        padding: `${theme.spacing.xs}px ${theme.spacing.md}px`,
        paddingLeft: 31,
        marginLeft: 30,
        color: theme.colorScheme === 'dark' ? theme.colors.dark[0] : theme.colors.gray[7],
        borderLeft: `1px solid ${
            theme.colorScheme === 'dark' ? theme.colors.dark[4] : theme.colors.gray[3]
        }`,

        '&:hover': {
            backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[7] : theme.colors.gray[0],
            color: theme.colorScheme === 'dark' ? theme.white : theme.black,
        },

        '&:active': {
            backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[7] : theme.colors.gray[0],
            color: theme.colorScheme === 'dark' ? theme.white : theme.black,
        },
    },

    chevron: {
        transition: 'transform 200ms ease',
    },
}));


/*
*  c={({ isActive }) =>
                isActive ? classes.activeLink : classes.link
            }*/

type NavbarLinkGroupProps = {
    icon: TablerIcon;
    label: string;
    links?: {label: string; link: string}[]

}

const NavbarLinkGroup = ({icon:Icon, label, links}: NavbarLinkGroupProps) => {
    const { classes } = useStyles();
    const [opened, setOpened] = useState(false)
    const [active, setActive] = useState(99)

    const hasLinks = Array.isArray(links);


    // @ts-ignore
    const items = (hasLinks ? links : []).map((item) => (
        <RouterNavLink
            className={classes.link}
            to={item.link}
            key={item.label}

        >
            {item.label}
        </RouterNavLink>
    ))

    return (
        <>
        <UnstyledButton className={classes.control} onClick={()=> setOpened((open)=> !open)}>
            <Group position="apart" spacing={0}>
                <Box sx={{display: "flex", alignItems: "center"}}>
                    <ThemeIcon variant="light" size={30}>
                        <Icon size={18}/>
                    </ThemeIcon>
                    <Box ml="md">{label}</Box>
                </Box>
                {hasLinks && (
                    <IconChevronRight
                        className={classes.chevron}
                        size={14}
                        stroke={1.5}
                        style={{
                            transform: opened ? `rotate(90deg)` : 'none',
                        }}
                    />
                )}
            </Group>
        </UnstyledButton>
            {hasLinks ? <Collapse in={opened}>{items}</Collapse> : null}
        </>
    );
};

export default NavbarLinkGroup;