import { configureStore } from '@reduxjs/toolkit'
import initTenantReducer from "../shared/InitTenantSlice";

export const rootReducer = {
  initTenant: initTenantReducer
};

export const store = configureStore({
  reducer: rootReducer,
});

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch