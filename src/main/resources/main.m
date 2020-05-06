%% 清空环境
%funcation evolutiontemp(Jm,T)

clc;clear
close all
%% 下载数据
% load scheduleData2 Jm T JmNumber
%工序 时间

%工件编号,工序号,批量,工序时间,总时间,设备编号
aaa=[1	1	2	3	6	3;
     1	2	2	8	16	1;
     1	3	2	9	18	2;
     1	4	2	2	4	4;
     1	5	2	3	6	6;
     1	6	2	2	4	5;
     2	1	3	6	18	2;
     2	2	3	8	24	3;
     2	3	3	2	6	6;
     2	4	3	5	15	5;
     2	5	3	3	9	1;
     2	6	3	3	9	4;
     3	1	2	4	8	3;
     3	2	2	7	14	4;
     3	3	2	6	12	6;
     3	4	2	5	10	1;
     3	5	2	9	18	1;
     3	6	2	1	2	5;
     4	1	4	2	8	4;
     4	2	4	4	16	1;
     4	3	4	4	16	3;
     4	4	4	1	4	2;
     4	5	4	1	4	5;
     4	6	4	3	12	6;
     5	1	3	6	18	2;
     5	2	3	8	24	2;
     5	3	3	7	21	3;
     5	4	3	8	24	6;
     5	5	3	5	15	1;
     5	6	3	4	12	4;
     6	1	2	2	4	2;
     6	2	2	4	8	4;
     6	3	2	6	12	6;
     6	4	2	1	2	1;
     6	5	2	5	10	5;
     6	6	2	3	6	3];
 temp=size(aaa); 
 ii=0;
 jj=0;
  iii=2;
  jjj=1;
 while iii<= temp(1,1)
     iii0=iii-1;
     while iii<= temp(1,1) && aaa(iii,1)==aaa(iii-1,1)
          %ii=ii+1;
          iii=iii+1;
     end     
     aaa1=aaa(iii0:iii-1,:);
     bbb(jjj,:)=aaa1(:,4)'; 
     ccc(jjj,:)=aaa1(:,6)'; 
     %ii=0;
     iii=iii+1;
     jjj=jjj+1;
 end 
T=bbb(:,:);
Jm=ccc(:,:);
% %% 输入数据
% Jm={3,1,2,4;
%     2,3,1,4;
%     2,4,1,3;
%     4,1,3,2};
%  T={3 4 5 2;
%     2 3 4 3;
%     4 6 5 8;
%     2 4 2 3};
Jm={3,1,2,4,6,5;
    2,3,5,6,1,4;
    3,4,6,1,2,5;
    4,1,3,2,5,6;
    5,2,3,6,1,4;
    2,4,6,1,5,3};
 T={3 8 9 2 3 2;
    6 8 2 5 3 3;
    4 7 6 5 9 1;
    2 4 4 3 1 3;
    6 8 7 8 5 4;
    2 4 6 1 5 3};
JmNumber=6;
%% 基本参数
NIND=40;        %个体数目
MAXGEN=50;      %最大遗传代数
GGAP=0.9;       %代沟
XOVR=0.8;       %交叉率
MUTR=0.6;       %变异率
gen=0;          %代计数器

[PNumber, MNumber]=size(Jm);  % size函数表示输出矩阵的行数和列数(Jm矩阵中,行为PNumber表示工件个数,列为MNumber表示工序个数)
trace=zeros(2, MAXGEN);      %寻优结果记录 (创建一个2行50列的零矩阵）
WNumber=PNumber*MNumber;     %工序总个数
%% 初始化
Number=zeros(1,PNumber);     % PNumber 工件个数
for i=1:PNumber
    Number(i)=MNumber;         %MNumber工序个数（将工序的个数存放在Number数据库中）
end

% 个体编码，第一层工序，第二层机器
Chrom=zeros(NIND,2*WNumber);
for j=1:NIND
    WPNumberTemp=Number;
    for i=1:WNumber
        %随机产生工序
        val=unidrnd(PNumber);
        while WPNumberTemp(val)==0
            val=unidrnd(PNumber);
        end
        %第一层代码表示工序
        Chrom(j,i)= val;
        WPNumberTemp(val)=WPNumberTemp(val)-1;
        %第2层代码表示机器
        Temp=Jm{val,MNumber-WPNumberTemp(val)};
        SizeTemp=length(Temp);
        %随机产生工序机器
        Chrom(j,i+WNumber)= unidrnd(SizeTemp);
    end
end
 
%计算目标函数值
[PVal, ObjV, P, S]=cal(Chrom,JmNumber,T,Jm);  

%% 循环寻找最优解
while gen<MAXGEN
    %分配适应度值
    FitnV=ranking(ObjV);  
    %选择操作
    SelCh=select('rws', Chrom, FitnV, GGAP);       
    %交叉操作
    SelCh=across(SelCh,XOVR,Jm,T);          
    %变异操作
    SelCh=aberranceJm(SelCh,MUTR,Jm,T);            
    
    %计算个体适应度值
    [PVal, ObjVSel, P, S]=cal(SelCh,JmNumber,T,Jm);   
    %重新插入新种群
    [Chrom, ObjV] =reins(Chrom, SelCh,1, 1, ObjV, ObjVSel);       
    %代计数器增加
    gen=gen+1;       
    
    %保存最优值
    trace(1, gen)=min(ObjV);       
    trace(2, gen)=mean(ObjV);  
    
    % 记录最佳值
    if gen==1
        Val1=PVal;
        Val2=P;
        MinVal=min(ObjV);%最小时间
        STemp=S;
    end
    %记录 最小的工序
    if MinVal> trace(1,gen)
        Val1=PVal;
        Val2=P;
        MinVal=trace(1,gen);
        STemp=S;
    end
    
end

% 当前最佳值
PVal=Val1; %工序时间
P=Val2;  %工序 
S=STemp; %调度基因含机器基因

%% 描绘解的变化
figure(1)
plot(trace(1,:));
hold on;
plot(trace(2,:),'-.');grid;
legend('解的变化','种群均值的变化');
xlabel('迭代次数');
ylabel('适应度值(s)');
title('算法搜索过程');
%% 显示最优解
figure(2);
MP=S(1,PNumber*MNumber+1:PNumber*MNumber*2);
for i=1:WNumber  
    val= P(1,i);
    a=(mod(val,100)); %工序
    b=((val-a)/100); %工件
    Temp=Jm{b,a};
    mText=Temp(MP(1,i));
    x1=PVal(1,i);
    x2=PVal(2,i);
    y1=mText-1;
    y2=mText-1;
    y3=mText;
    PlotRec(x1,x2,mText);
    PlotRec(PVal(1,i),PVal(2,i),mText-0.5);
    hold on;
    fill([x1,x2,x2,x1],[y1,y1,y2,y2],[1-1/b,1/b,b/PNumber]);
    fill([x1,x2,x2,x1],[y2,y2,y3,y3],[1-1/b,1/b,b/PNumber]);
    text((x1+x2)/2,mText-0.25,num2str(P(i)));
end
xlabel('时间(s)');
ylabel('加工机器');
title('甘特图');