<%@ page import="com.mehdilagdimi.macnss_spring_mvc.config.DispatcherConfig" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/@tailwindcss/custom-forms@0.2.1/dist/custom-forms.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<div class="bg-white w-full relative flex min-h-screen flex-row justify-center overflow-hidden py-6 px-4 sm:py-12">
    <div class="w-full hidden sm:w-[250px] md:w-[400px] lg:w-[1200px] bg-grey-50 sm:flex  justify-content-center align-items-center">
        <lottie-player src="https://assets10.lottiefiles.com/packages/lf20_xhlbndhm.json" class="text-center "
                       background="transparent" speed="1" loop autoplay></lottie-player>
    </div>

    <div class="w-full bg-white grid grid-cols-12 grid-rows-6 p-4">
        <div class="flex flex-col justify-around  col-start-2 col-end-12 row-start-2 row-end-6">

            <form:form action="agentlogin" modelAttribute="agent" method="POST" name="loginfom" id="formId">
                <!-- need to associate this data with customer id -->
                <form:hidden path="id" />
                <div class="text-center font-semibold text-purple-800">
                    <img src="assets/testlogo.png" fill="currentColor" class="mx-auto h-36"/>
                </div>
                <div>
                    <div class="m-5 text-center rounded-sm">
                        <!-- <div class="col-span-2 bg-red-200 "></div> -->
                        <div class="border-l-4 border-custGreen rounded-sm">
                <form:input path="email" class="w-full bg-gray-50 outline-none py-3 px-2" type="email" name="email"
                                   placeholder="Email" required="true" />
                        </div>
                        <%--                        <div *ngIf="email?.invalid && (email?.dirty || email?.touched)"--%>
                        <%--                             class="text-red-500 text-sm">--%>

                        <%--                            <div *ngIf="email?.errors?.['required']">--%>
                        <%--                                Email is required.--%>
                        <%--                            </div>--%>
                        <%--                            <div *ngIf="email?.errors?.['email']">--%>
                        <%--                                Email must be a valid email.--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>

                    </div>
                    <div class="m-5 text-center rounded-sm">
                        <!-- <div class="col-span-2 bg-red-200 "></div> -->
                        <div class="border-l-4 border-custGreen rounded-sm">
                    <form:input path="password"  class="w-full bg-gray-50 outline-none py-3 px-2" type="password" name="password"
                                   placeholder="Password" required="true" />
                        </div>
                        <%--                        <div *ngIf="password?.invalid && (password?.dirty || password?.touched)"--%>
                        <%--                             class="text-red-500 text-sm">--%>

                        <%--                            <div *ngIf="password?.errors?.['required']">--%>
                        <%--                                Password is required.--%>
                        <%--                            </div>--%>
                        <%--                            <div *ngIf="password?.errors?.['pattern']">--%>
                        <%--                                Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character.--%>
                        <%--                            </div>--%>

                        <%--                        </div>--%>
                    </div>


                    <form:button type="submit" id="submitBtnId"
                            class='w-full  shadow-sm rounded-md py-3 text-white font-semibold'>
                        SUBMIT
                    </form:button>
                </div>
            </form:form>


        </div>

    </div>
</div>

</body>
</html>
