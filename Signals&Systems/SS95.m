%%
clear;
clc;
close all;
b = 1;
a = [1 2];
t = [-5:0.01:5];
ts = [0:0.01:5];
hs = impulse(b,a,ts);
plot(ts,hs);xlabel('t');ylabel('h(t)');title('��λ�弤��Ӧ');
grid;
%%
b = 1;
a = [-1 2];
hs = impulse(b,a,ts);
plot(-ts,hs);xlabel('t');ylabel('h(t)');title('��λ�弤��Ӧ');
grid;