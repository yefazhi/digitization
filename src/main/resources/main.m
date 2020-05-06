%% ��ջ���
%funcation evolutiontemp(Jm,T)

clc;clear
close all
%% ��������
% load scheduleData2 Jm T JmNumber
%���� ʱ��

%�������,�����,����,����ʱ��,��ʱ��,�豸���
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
% %% ��������
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
%% ��������
NIND=40;        %������Ŀ
MAXGEN=50;      %����Ŵ�����
GGAP=0.9;       %����
XOVR=0.8;       %������
MUTR=0.6;       %������
gen=0;          %��������

[PNumber, MNumber]=size(Jm);  % size������ʾ������������������(Jm������,��ΪPNumber��ʾ��������,��ΪMNumber��ʾ�������)
trace=zeros(2, MAXGEN);      %Ѱ�Ž����¼ (����һ��2��50�е������
WNumber=PNumber*MNumber;     %�����ܸ���
%% ��ʼ��
Number=zeros(1,PNumber);     % PNumber ��������
for i=1:PNumber
    Number(i)=MNumber;         %MNumber���������������ĸ��������Number���ݿ��У�
end

% ������룬��һ�㹤�򣬵ڶ������
Chrom=zeros(NIND,2*WNumber);
for j=1:NIND
    WPNumberTemp=Number;
    for i=1:WNumber
        %�����������
        val=unidrnd(PNumber);
        while WPNumberTemp(val)==0
            val=unidrnd(PNumber);
        end
        %��һ������ʾ����
        Chrom(j,i)= val;
        WPNumberTemp(val)=WPNumberTemp(val)-1;
        %��2������ʾ����
        Temp=Jm{val,MNumber-WPNumberTemp(val)};
        SizeTemp=length(Temp);
        %��������������
        Chrom(j,i+WNumber)= unidrnd(SizeTemp);
    end
end
 
%����Ŀ�꺯��ֵ
[PVal, ObjV, P, S]=cal(Chrom,JmNumber,T,Jm);  

%% ѭ��Ѱ�����Ž�
while gen<MAXGEN
    %������Ӧ��ֵ
    FitnV=ranking(ObjV);  
    %ѡ�����
    SelCh=select('rws', Chrom, FitnV, GGAP);       
    %�������
    SelCh=across(SelCh,XOVR,Jm,T);          
    %�������
    SelCh=aberranceJm(SelCh,MUTR,Jm,T);            
    
    %���������Ӧ��ֵ
    [PVal, ObjVSel, P, S]=cal(SelCh,JmNumber,T,Jm);   
    %���²�������Ⱥ
    [Chrom, ObjV] =reins(Chrom, SelCh,1, 1, ObjV, ObjVSel);       
    %������������
    gen=gen+1;       
    
    %��������ֵ
    trace(1, gen)=min(ObjV);       
    trace(2, gen)=mean(ObjV);  
    
    % ��¼���ֵ
    if gen==1
        Val1=PVal;
        Val2=P;
        MinVal=min(ObjV);%��Сʱ��
        STemp=S;
    end
    %��¼ ��С�Ĺ���
    if MinVal> trace(1,gen)
        Val1=PVal;
        Val2=P;
        MinVal=trace(1,gen);
        STemp=S;
    end
    
end

% ��ǰ���ֵ
PVal=Val1; %����ʱ��
P=Val2;  %���� 
S=STemp; %���Ȼ��򺬻�������

%% ����ı仯
figure(1)
plot(trace(1,:));
hold on;
plot(trace(2,:),'-.');grid;
legend('��ı仯','��Ⱥ��ֵ�ı仯');
xlabel('��������');
ylabel('��Ӧ��ֵ(s)');
title('�㷨��������');
%% ��ʾ���Ž�
figure(2);
MP=S(1,PNumber*MNumber+1:PNumber*MNumber*2);
for i=1:WNumber  
    val= P(1,i);
    a=(mod(val,100)); %����
    b=((val-a)/100); %����
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
xlabel('ʱ��(s)');
ylabel('�ӹ�����');
title('����ͼ');