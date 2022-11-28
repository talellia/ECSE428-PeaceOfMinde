import React from 'react'

import { Helmet } from 'react-helmet'

import './account.css'

const Account = (props) => {
  return (
    <div className="page-container">
      <Helmet>
        <title>Page - exported project</title>
        <meta property="og:title" content="Page - exported project" />
      </Helmet>
      <div className="page-desktop3">
        <div className="page-info">
        </div>
        <div className="page-accountinfo">
        </div>
        <span className="page-text">
          <span>Account &gt; Account Info</span>
        </span>
        <span className="page-text02">
          <span>Account Info</span>
        </span>
        <button className="page-text06" onClick={setToInput("nameinput")}>
          <span>Modify</span>
        </button>
        <span className="page-text08" onClick={setToInput("x")}>
          <span>Modify</span>
        </span>
        <span className="page-text10" onClick={setToInput("x")}>
          <span>Modify</span>
        </span>
        <span className="page-text12" onClick={setToInput("x")}>
          <span>Modify</span>
        </span>
        <span className="page-text14" onClick={setToInput("x")}>
          <span>Modify</span>
        </span>
        <span className="page-text16" onClick={setToInput("x")}>
          <span>Modify</span>
        </span>
        <span className="page-text18" onClick={setToInput("x")}>
          <span>Modify</span>
        </span>
        <span className="page-text04">
          <span>Name</span>
        </span>
        <span className="page-text20">
          <span>Last Name</span>
        </span>
        <span className="page-text22">
          <span>UserName</span>
        </span>
        <span className="page-text24">
          <span>Email</span>
        </span>
        <span className="page-text26">
          <span>Password</span>
        </span>
        <span className="page-text28">
          <span>Address</span>
        </span>
        <span className="page-text30">
          <span>About me</span>
        </span>
        <div id="nameinput" className="page-component28">
          <span className="page-text32">
            <span id="name">
              Name
              <span
                dangerouslySetInnerHTML={{
                  __html: ' ',
                }}
              />
            </span>
          </span>
        </div>
        <div className="page-component31">
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/bb7476fd-8e97-457c-9c40-26d0e285d27c?org_if_sml=1390"
            alt="Rectangle13I862"
            className="page-rectangle131"
          />
          <span className="page-text34">
            <span>Email</span>
          </span>
        </div>
        <div className="page-component32">
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/39bffbf5-1e14-478c-ad4b-9070116f1d06?org_if_sml=1390"
            alt="Rectangle13I862"
            className="page-rectangle132"
          />
          <span className="page-text36">
            <span>
              Password
              <span
                dangerouslySetInnerHTML={{
                  __html: ' ',
                }}
              />
            </span>
          </span>
        </div>
        <div className="page-component33">
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/36687614-ea5c-4303-a0ad-95f21e3eca1d?org_if_sml=1390"
            alt="Rectangle13I862"
            className="page-rectangle133"
          />
          <span className="page-text38">
            <span>
              Address
              <span
                dangerouslySetInnerHTML={{
                  __html: ' ',
                }}
              />
            </span>
          </span>
        </div>
        <div className="page-component30">
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/64ff9e52-c141-474a-a81c-03db1153c9d2?org_if_sml=1390"
            alt="Rectangle13I862"
            className="page-rectangle134"
          />
          <span className="page-text40">
            <span>UserName</span>
          </span>
        </div>
        <div className="page-component29">
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/8c8fdc34-f673-4e53-bc6a-ed430ff027e7?org_if_sml=1390"
            alt="Rectangle13I862"
            className="page-rectangle135"
          />
          <span className="page-text42">
            <span>Last Name</span>
          </span>
        </div>
        <div className="page-component34">
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/9e0bf7e3-953b-4dba-a51a-da2c5d094175?org_if_sml=11210"
            alt="Rectangle148621"
            className="page-rectangle14"
          />
          <span className="page-text44">
            <span>
              About Me
              <span
                dangerouslySetInnerHTML={{
                  __html: ' ',
                }}
              />
            </span>
          </span>
        </div>
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/97a5d1ec-151a-42c8-a29b-f75e40648e3c?org_if_sml=11122"
          alt="Rectangle158622"
          className="page-rectangle15"
        />
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/7e95193d-2dbe-4f27-a6ce-fcea3c3f8764?org_if_sml=11122"
          alt="Rectangle168623"
          className="page-rectangle16"
        />
        <span className="page-text46">
          <span>What information is shared?</span>
        </span>
        <span className="page-text48">
          <span>
            Peace of mind only shares required information such as adress after
            the babysiting requests have been scheduled and accpeted by both
            parties.
            <span
              dangerouslySetInnerHTML={{
                __html: ' ',
              }}
            />
          </span>
        </span>
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/7a8a5827-fcd1-43bc-859b-edff8474cd53?org_if_sml=11034"
          alt="Rectangle178623"
          className="page-rectangle17"
        />
        <span className="page-text50">
          <span>
            Why can’t i see some informations?
            <span
              dangerouslySetInnerHTML={{
                __html: ' ',
              }}
            />
          </span>
        </span>
        <span className="page-text52">
          <span>
            We hide some information for your own security protection. You would
            not want others to see your password now would you?
            <span
              dangerouslySetInnerHTML={{
                __html: ' ',
              }}
            />
          </span>
        </span>
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/461c7bc1-900f-4f99-bf52-e516a7bd25a0?org_if_sml=1930"
          alt="Rectangle248625"
          className="page-rectangle24"
        />
        <span className="page-text54">
          <span>What information can i change?</span>
        </span>
        <span className="page-text56">
          <span>
            All information can be changed. Some may require a request approval.
            <span
              dangerouslySetInnerHTML={{
                __html: ' ',
              }}
            />
          </span>
        </span>
        <img
          src="/playground_assets/component358623-b58s.svg"
          alt="Component358623"
          className="page-component35"
        />
        <div className="page-component36">
          <img
            src="/playground_assets/rectangle188623-i7kh.svg"
            alt="Rectangle188623"
            className="page-rectangle18"
          />
          <img
            src="/playground_assets/rectangle218624-0zdi.svg"
            alt="Rectangle218624"
            className="page-rectangle21"
          />
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/e852bdbd-ca91-4a0d-9c98-86efc31fe010?org_if_sml=1123"
            alt="Rectangle208624"
            className="page-rectangle20"
          />
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/4eb39d72-8cb1-4ed4-b0c5-94bfa9e9e740?org_if_sml=1151"
            alt="Rectangle198623"
            className="page-rectangle19"
          />
          <img
            src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/8d02090a-7722-4b02-8601-4e36a7a014cd?org_if_sml=1158"
            alt="Ellipse48623"
            className="page-ellipse4"
          />
        </div>
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/8615101b-657a-49dd-ae9f-0d77067d2282?org_if_sml=1123"
          alt="Rectangle228625"
          className="page-rectangle22"
        />
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/b5a1fd1c-b190-4676-9bcc-3e328c3dcf90?org_if_sml=1172"
          alt="Rectangle238625"
          className="page-rectangle23"
        />
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/43be3e11-ee01-4a45-93fb-7ac97eb1b035?org_if_sml=1165"
          alt="Rectangle258625"
          className="page-rectangle25"
        />
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/6ad6c523-ae70-457c-8321-cb8d88be71c6/9076e937-9e00-4809-be30-133f6c58d632?org_if_sml=1123"
          alt="Ellipse58625"
          className="page-ellipse5"
        />
        <img
          alt="Rectangle113"
          src="/playground_assets/rectangle113-hh7-1900w.png"
          className="page-rectangle1"
        />
        <div className="page-component3">
          <img
            alt="Rectangle3I252"
            src="/playground_assets/rectangle3i252-8nkh-200h.png"
            className="page-rectangle3"
          />
          <div className="page-frameiconperson">
            <div className="page-group">
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-73up.svg"
                className="page-vector"
              />
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-3dkd.svg"
                className="page-vector1"
              />
            </div>
          </div>
          <div className="page-frameiconmenu">
            <div className="page-group1">
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-f0t.svg"
                className="page-vector2"
              />
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-wqvw.svg"
                className="page-vector3"
              />
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-497q.svg"
                className="page-vector4"
              />
            </div>
          </div>
        </div>
        <img
          alt="logonobackground124"
          src="/playground_assets/logonobackground124-04sp-200h.png"
          className="page-logonobackground1"
        />
      </div>
    </div>
  )
}

function setToInput(id){
  console.log(id);
  console.log(document.getElementById(id));
  console.log(document.getElementById("nameinput"));
  
  
}

export default Account
