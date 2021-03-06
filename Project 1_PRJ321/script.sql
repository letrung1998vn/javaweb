USE [master]
GO
/****** Object:  Database [StudentPageDetail]    Script Date: 7/5/2018 10:00:08 PM ******/
CREATE DATABASE [StudentPageDetail]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'StudentPageDetail', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\StudentPageDetail.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'StudentPageDetail_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\StudentPageDetail_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [StudentPageDetail] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [StudentPageDetail].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [StudentPageDetail] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [StudentPageDetail] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [StudentPageDetail] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [StudentPageDetail] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [StudentPageDetail] SET ARITHABORT OFF 
GO
ALTER DATABASE [StudentPageDetail] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [StudentPageDetail] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [StudentPageDetail] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [StudentPageDetail] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [StudentPageDetail] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [StudentPageDetail] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [StudentPageDetail] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [StudentPageDetail] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [StudentPageDetail] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [StudentPageDetail] SET  DISABLE_BROKER 
GO
ALTER DATABASE [StudentPageDetail] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [StudentPageDetail] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [StudentPageDetail] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [StudentPageDetail] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [StudentPageDetail] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [StudentPageDetail] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [StudentPageDetail] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [StudentPageDetail] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [StudentPageDetail] SET  MULTI_USER 
GO
ALTER DATABASE [StudentPageDetail] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [StudentPageDetail] SET DB_CHAINING OFF 
GO
ALTER DATABASE [StudentPageDetail] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [StudentPageDetail] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [StudentPageDetail] SET DELAYED_DURABILITY = DISABLED 
GO
USE [StudentPageDetail]
GO
/****** Object:  Table [dbo].[account]    Script Date: 7/5/2018 10:00:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account](
	[username] [varchar](8) NOT NULL,
	[password] [varchar](25) NOT NULL,
	[status] [varchar](10) NOT NULL,
 CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[feedback]    Script Date: 7/5/2018 10:00:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[feedback](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fbDate] [datetime] NULL,
	[contents] [nvarchar](250) NULL,
	[studentID] [varchar](8) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_feedback] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[marks]    Script Date: 7/5/2018 10:00:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[marks](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[classID] [varchar](8) NULL,
	[studentID] [varchar](8) NULL,
	[subjectID] [varchar](8) NULL,
	[blockSemester] [varchar](12) NULL,
	[subjectAvg] [float] NULL,
	[status] [varchar](12) NULL,
 CONSTRAINT [PK_marks] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[student]    Script Date: 7/5/2018 10:00:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[student](
	[studentID] [varchar](8) NOT NULL,
	[firstName] [varchar](15) NOT NULL,
	[lastName] [varchar](15) NOT NULL,
	[middleName] [varchar](15) NULL,
	[address] [varchar](250) NULL,
	[phone] [varchar](11) NULL,
	[sex] [bit] NULL,
 CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED 
(
	[studentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[subject]    Script Date: 7/5/2018 10:00:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[subject](
	[subjectID] [varchar](8) NOT NULL,
	[subjectName] [varchar](50) NULL,
	[NoOfSlot] [int] NULL,
	[prerequisite] [varchar](250) NULL,
	[credits] [int] NULL,
 CONSTRAINT [PK_subject] PRIMARY KEY CLUSTERED 
(
	[subjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[account] ([username], [password], [status]) VALUES (N'se53215', N'123456789', N'dropout')
INSERT [dbo].[account] ([username], [password], [status]) VALUES (N'se55125', N'111111', N'break')
INSERT [dbo].[account] ([username], [password], [status]) VALUES (N'se63152', N'123456', N'studying')
SET IDENTITY_INSERT [dbo].[feedback] ON 

INSERT [dbo].[feedback] ([id], [fbDate], [contents], [studentID], [status]) VALUES (1, CAST(N'2018-07-02 00:00:00.000' AS DateTime), N'Some marks of courses is not correct. Please, explain them for me_se63152_pro201-4.5-Fail_pro201-6.5-Pass_pro201-7.8-Improved_', N'se63152', 1)
INSERT [dbo].[feedback] ([id], [fbDate], [contents], [studentID], [status]) VALUES (2, CAST(N'2018-07-02 00:00:00.000' AS DateTime), N'Some marks of courses is not correct. Please, explain them for me_se63152_prj311-3.5-Fail_prj311-4.9-Fail_prj311-7.4-Pass_csd201-7.5-Pass_csd201-5.1-Fail_', N'se63152', 1)
INSERT [dbo].[feedback] ([id], [fbDate], [contents], [studentID], [status]) VALUES (3, CAST(N'2018-07-03 00:00:00.000' AS DateTime), N'Some marks of courses is not correct. Please, explain them for me_se63152_prj321-0.0-Not_Started_csd201-7.5-Pass_csd201-5.1-Fail_', N'se63152', 1)
SET IDENTITY_INSERT [dbo].[feedback] OFF
SET IDENTITY_INSERT [dbo].[marks] ON 

INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (1, N'012', N'se63152', N'prj311', N'Summer2018_2', 3.5, N'Fail')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (2, N'013', N'se63152', N'prj311', N'Summer2017_1', 4.9, N'Fail')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (3, N'014', N'se63152', N'prj311', N'Winter2018_1', 7.4, N'Pass')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (4, N'015', N'se63152', N'pro201', N'Spring2016_3', 4.5, N'Fail')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (5, N'016', N'se63152', N'pro201', N'Spring2017_1', 6.5, N'Pass')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (6, N'017', N'se63152', N'csd201', N'Spring2018_4', 7.5, N'Pass')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (7, N'019', N'se63152', N'csd201', N'Summer2016_2', 5.1, N'Fail')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (8, N'022', N'se63152', N'pro201', N'Winter2018_3', 7.8, N'Improved')
INSERT [dbo].[marks] ([id], [classID], [studentID], [subjectID], [blockSemester], [subjectAvg], [status]) VALUES (9, N'222', N'se63152', N'prj321', N'Summer2018_2', 0, N'Not_Started')
SET IDENTITY_INSERT [dbo].[marks] OFF
INSERT [dbo].[student] ([studentID], [firstName], [lastName], [middleName], [address], [phone], [sex]) VALUES (N'se53215', N'Tran', N'khoa', N'minh', N'Truong Chinh', N'093155475', 1)
INSERT [dbo].[student] ([studentID], [firstName], [lastName], [middleName], [address], [phone], [sex]) VALUES (N'se55125', N'Nguyen', N'Minh', N'Thanh', N'Q12', N'08964751', 1)
INSERT [dbo].[student] ([studentID], [firstName], [lastName], [middleName], [address], [phone], [sex]) VALUES (N'se63152', N'le', N'trung', NULL, N'50/6 tl 22 p.tl,q12', N'034028256', 1)
INSERT [dbo].[subject] ([subjectID], [subjectName], [NoOfSlot], [prerequisite], [credits]) VALUES (N'csd201', N'Data Structure and Algorithm', 30, N'final>4,each creadit must >0', 7)
INSERT [dbo].[subject] ([subjectID], [subjectName], [NoOfSlot], [prerequisite], [credits]) VALUES (N'prj311', N'Java Desktop', 30, N'final>4,each creadit must >0', 5)
INSERT [dbo].[subject] ([subjectID], [subjectName], [NoOfSlot], [prerequisite], [credits]) VALUES (N'prj321', N'Java Web', 30, N'final>4,each creadit must >0', 8)
INSERT [dbo].[subject] ([subjectID], [subjectName], [NoOfSlot], [prerequisite], [credits]) VALUES (N'pro201', N'Front-end', 30, N'final>4,each creadit must >0', 6)
ALTER TABLE [dbo].[feedback]  WITH CHECK ADD  CONSTRAINT [FK_feedback_student] FOREIGN KEY([studentID])
REFERENCES [dbo].[student] ([studentID])
GO
ALTER TABLE [dbo].[feedback] CHECK CONSTRAINT [FK_feedback_student]
GO
ALTER TABLE [dbo].[marks]  WITH CHECK ADD  CONSTRAINT [FK_marks_student] FOREIGN KEY([studentID])
REFERENCES [dbo].[student] ([studentID])
GO
ALTER TABLE [dbo].[marks] CHECK CONSTRAINT [FK_marks_student]
GO
ALTER TABLE [dbo].[marks]  WITH CHECK ADD  CONSTRAINT [FK_marks_subject1] FOREIGN KEY([subjectID])
REFERENCES [dbo].[subject] ([subjectID])
GO
ALTER TABLE [dbo].[marks] CHECK CONSTRAINT [FK_marks_subject1]
GO
ALTER TABLE [dbo].[student]  WITH CHECK ADD  CONSTRAINT [FK_student_account] FOREIGN KEY([studentID])
REFERENCES [dbo].[account] ([username])
GO
ALTER TABLE [dbo].[student] CHECK CONSTRAINT [FK_student_account]
GO
USE [master]
GO
ALTER DATABASE [StudentPageDetail] SET  READ_WRITE 
GO
