import java.io.*;
import java.util.*;
class Main
{ 
static final int glob=10;
public static void main(String args[])
{
int n,in,mean=0,max=-1,i,j,count;
Scanner s=new Scanner(System.in);
System.out.println("Enter the size of array");
n=s.nextInt();
int[] a=new int[n];
int[] b=new int[n];
System.out.println("Enter the values of array");
for(i=0;i<n;i++)
{
a[i]=s.nextInt();
mean+=a[i];
}
mean=mean/n;
for(i=0;i<n;i++)
{
count=0;
for(j=i+1;j<n;j++)
{
if(a[i]==a[j])
count++;
}
if(count>max)
max=count;
}
System.out.println("Choose an option between 1-3:");
System.out.println("1: replace with global value");
System.out.println("2: replace with mean value");
System.out.println("3: replace with most probable value");
do
{
System.out.println("Choose an option between 1-3");
in=s.nextInt();
switch(in)
{
case 1:
for(i=0;i<n;i++)
{
if(a[i]==0)
b[i]=glob;
else
b[i]=a[i];
}
System.out.println(Arrays.toString(b));
break;
case 2:
for(i=0;i<n;i++)
{
if(a[i]==0)
b[i]=mean;
else
b[i]=a[i];
}
System.out.println(Arrays.toString(b));
break;
case 3:
for(i=0;i<n;i++)
{
if(a[i]==0)
b[i]=max;
else
b[i]=a[i];
}
System.out.println(Arrays.toString(b));
break;
}
}while(in<4);
}}