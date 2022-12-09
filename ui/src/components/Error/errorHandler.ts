//https://www.npmjs.com/package/react-error-boundary

const errorHandler = (error: any, info: any) => {
    console.error("an unexpected error occurred", error, JSON.stringify(info));
};

export default errorHandler;