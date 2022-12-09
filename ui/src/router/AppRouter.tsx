import React from "react";
import {Route, Routes} from "react-router-dom";
import {ErrorBoundary} from "react-error-boundary";
import ErrorPage from "../components/Error/ErrorPage";
import errorHandler from "../components/Error/errorHandler";
import {DASHBOARD} from "./navigationPaths";
import Dashboard from "../components/Dashboard/Dashboard";

const AppRouter = () => {


    return (
        <>
            <ErrorBoundary FallbackComponent={ErrorPage} onError={errorHandler}>

                <Routes>
                    <Route
                        path={DASHBOARD}
                        element={<Dashboard/>}
                    />
                    <Route
                        path={"/error"}
                        element={<ErrorPage/>}
                    />

                </Routes>

            </ErrorBoundary>
        </>
    );
};

export default AppRouter;